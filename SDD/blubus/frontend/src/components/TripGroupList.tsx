"use client";
import React, { useRef } from 'react';
import { TripGroup } from '../models/TripGroup';
import { BusBookingTile } from './BusBookingTile';
import { DndProvider, useDrag, useDrop } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';
import styles from './TripGroupList.module.css';

interface TripGroupListProps {
  tripGroups: TripGroup[];
  onReorder: (from: number, to: number) => void;
}

const ItemType = 'TRIP_GROUP';

interface DraggableTripGroupProps {
  group: TripGroup;
  index: number;
  moveGroup: (from: number, to: number) => void;
}

// Helper to format date as dd-mm-yyyy
function formatDate(dateStr: string) {
  if (!dateStr) return '';
  const d = new Date(dateStr);
  if (isNaN(d.getTime())) return dateStr;
  const day = String(d.getDate()).padStart(2, '0');
  const month = String(d.getMonth() + 1).padStart(2, '0');
  const year = d.getFullYear();
  return `${day}-${month}-${year}`;
}

const DraggableTripGroup: React.FC<DraggableTripGroupProps> = ({ group, index, moveGroup }) => {
  const ref = useRef<HTMLDivElement>(null);
  const [, drop] = useDrop({
    accept: ItemType,
    hover(item: { index: number }, monitor) {
      if (!ref.current) return;
      const dragIndex = item.index;
      const hoverIndex = index;
      if (dragIndex === hoverIndex) return;
      moveGroup(dragIndex, hoverIndex);
      item.index = hoverIndex;
    },
  });
  const [{ isDragging }, drag] = useDrag({
    type: ItemType,
    item: { index },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  });
  drag(drop(ref));

  // Keyboard navigation: move up/down with arrow keys
  const handleKeyDown = (e: React.KeyboardEvent<HTMLDivElement>) => {
    if (e.key === 'ArrowUp' && index > 0) {
      moveGroup(index, index - 1);
      e.preventDefault();
    } else if (e.key === 'ArrowDown' && typeof moveGroup === 'function') {
      moveGroup(index, index + 1);
      e.preventDefault();
    }
  };

  // Helper to truncate and show tooltip
  const truncate = (str: string) =>
    str.length > 30 ? str.slice(0, 30) + '…' : str;

  return (
    <div
      ref={ref}
      role="listitem"
      tabIndex={0}
      aria-label={`Trip group from ${group.source} to ${group.destination} on ${group.travelDate}`}
      aria-grabbed={isDragging}
      onKeyDown={handleKeyDown}
      className={styles.tripGroup}
      style={{ opacity: isDragging ? 0.5 : 1 }}
    >
      <div className={styles.tripGroupHeader}>
        <span
          className={styles.location}
          title={group.source}
          aria-label={`Source: ${group.source}`}
        >
          <strong>From:</strong> {truncate(group.source)}
        </span>
        <span className={styles.location} style={{ marginLeft: 16 }}
          title={group.destination}
          aria-label={`Destination: ${group.destination}`}
        >
          <strong>To:</strong> {truncate(group.destination)}
        </span>
        <span className={styles.date} style={{ marginLeft: 16 }}>
          <strong>Date:</strong> {formatDate(group.travelDate)}
        </span>
      </div>
      <div className={styles.busTiles}>
        {group.buses.map(bus => (
          <BusBookingTile key={bus.id} booking={bus} />
        ))}
      </div>
    </div>
  );
};

export const TripGroupList: React.FC<TripGroupListProps> = ({ tripGroups, onReorder }) => {
  const moveGroup = (from: number, to: number) => {
    if (from !== to) onReorder(from, to);
  };
  return (
    <DndProvider backend={HTML5Backend}>
      <div role="list" aria-label="Trip Groups" className={styles.tripGroupList}>
        {tripGroups.map((group, idx) => (
          <DraggableTripGroup
            key={group.order}
            group={group}
            index={idx}
            moveGroup={moveGroup}
          />
        ))}
      </div>
    </DndProvider>
  );
};
