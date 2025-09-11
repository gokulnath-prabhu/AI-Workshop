"use client";
import React, { createContext, useContext, useState, ReactNode } from 'react';
import { TripGroup } from '../models/TripGroup';

interface TripGroupsContextType {
  tripGroups: TripGroup[];
  setTripGroups: (groups: TripGroup[]) => void;
  addTripGroup: (group: TripGroup) => { success: boolean; error?: string };
  reorderTripGroups: (from: number, to: number) => void;
}

const TripGroupsContext = createContext<TripGroupsContextType | undefined>(undefined);

export const TripGroupsProvider = ({ children }: { children: ReactNode }) => {
  const [tripGroups, setTripGroups] = useState<TripGroup[]>([]);

  const addTripGroup = (group: TripGroup): { success: boolean; error?: string } => {
    // Validation: required fields
    const allowedPattern = /^[\w\s\-,.]{1,}$/u;
    if (!group.source || !group.destination || !group.travelDate) {
      return { success: false, error: 'Source, destination, and date are required.' };
    }
    if (!allowedPattern.test(group.source) || !allowedPattern.test(group.destination)) {
      return { success: false, error: 'Only letters, numbers, spaces, and - , . are allowed in location names.' };
    }
    // Prevent duplicate (same source, destination, date)
    const duplicate = tripGroups.some(g =>
      g.source.trim().toLowerCase() === group.source.trim().toLowerCase() &&
      g.destination.trim().toLowerCase() === group.destination.trim().toLowerCase() &&
      g.travelDate === group.travelDate
    );
    if (duplicate) {
      return { success: false, error: 'A trip group with the same source, destination, and date already exists.' };
    }
    setTripGroups(prev => [...prev, group]);
    return { success: true };
  };

  const reorderTripGroups = (from: number, to: number) => {
    setTripGroups(prev => {
      const updated = [...prev];
      const [moved] = updated.splice(from, 1);
      updated.splice(to, 0, moved);
      return updated.map((g, idx) => ({ ...g, order: idx }));
    });
  };

  return (
    <TripGroupsContext.Provider value={{ tripGroups, setTripGroups, addTripGroup, reorderTripGroups }}>
      {children}
    </TripGroupsContext.Provider>
  );
};

export const useTripGroups = () => {
  const context = useContext(TripGroupsContext);
  if (!context) throw new Error('useTripGroups must be used within a TripGroupsProvider');
  return context;
};
