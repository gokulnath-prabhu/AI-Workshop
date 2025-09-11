import React from 'react';
import styles from './EmptyState.module.css';

interface EmptyStateProps {
  onAddTripGroup: () => void;
}

export const EmptyState: React.FC<EmptyStateProps> = ({ onAddTripGroup }) => (
  <div
    role="alert"
    aria-live="polite"
    className={styles.emptyState}
  >
    <p className={styles.emptyStateText}>
      <span role="img" aria-label="bus">🚌</span> No trips found.<br />
      Start by adding a new trip group!
    </p>
    <button
      onClick={onAddTripGroup}
      aria-label="Add new trip group"
      className={styles.addButton}
      onKeyDown={e => {
        if (e.key === 'Enter' || e.key === ' ') {
          onAddTripGroup();
        }
      }}
    >
      Add Trip Group
    </button>
  </div>
);
