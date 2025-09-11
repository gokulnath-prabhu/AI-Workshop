"use client";

import { TripGroupsProvider, useTripGroups } from '../context/TripGroupsContext';
import { TripGroupList } from '../components/TripGroupList';
import { EmptyState } from '../components/EmptyState';
import React, { useState } from 'react';
import styles from './page.module.css';


function MainPage() {
  const { tripGroups, addTripGroup, reorderTripGroups } = useTripGroups();
  const [showForm, setShowForm] = useState(false);
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [dateValue, setDateValue] = useState("");
  const [error, setError] = useState<string | null>(null);

  const handleAddTripGroup = () => {
    setShowForm(true);
    setSource("");
    setDestination("");
    setDateValue("");
    setError(null);
  };

  const handleFormSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    const result = addTripGroup({
      source: source.trim(),
      destination: destination.trim(),
      travelDate: dateValue,
      buses: [],
      order: tripGroups.length
    });
    if (!result.success) {
      setError(result.error || 'Unknown error');
    } else {
      setShowForm(false);
      setSource("");
      setDestination("");
      setDateValue("");
      setError(null);
    }
  };

  return (
    <main className={styles.pageMain}>
      <h1 className={styles.heading}>Bus Trip Groups</h1>
      {showForm && (
        <form onSubmit={handleFormSubmit} className={styles.tripForm}>
          <label htmlFor="trip-source" className={styles.formLabel}>Source:</label>
          <input
            id="trip-source"
            type="text"
            value={source}
            onChange={e => setSource(e.target.value)}
            required
            maxLength={60}
            className={styles.formInput}
            placeholder="Enter source location"
            aria-label="Source location"
          />
          <label htmlFor="trip-destination" className={styles.formLabel}>Destination:</label>
          <input
            id="trip-destination"
            type="text"
            value={destination}
            onChange={e => setDestination(e.target.value)}
            required
            maxLength={60}
            className={styles.formInput}
            placeholder="Enter destination location"
            aria-label="Destination location"
          />
          <label htmlFor="trip-date" className={styles.formLabel}>Travel Date:</label>
          <input
            id="trip-date"
            type="date"
            value={dateValue}
            onChange={e => setDateValue(e.target.value)}
            required
            className={styles.formInput}
          />
          <button type="submit" className={styles.addButton}>Add</button>
          <button type="button" onClick={() => setShowForm(false)} className={styles.cancelButton}>Cancel</button>
          {error && <span className={styles.errorMsg}>{error}</span>}
        </form>
      )}
      {tripGroups.length === 0 ? (
        <EmptyState onAddTripGroup={handleAddTripGroup} />
      ) : (
        <>
          <button
            onClick={handleAddTripGroup}
            className={styles.addButtonMain}
            aria-label="Add new trip group"
          >
            Add Trip Group
          </button>
          <TripGroupList tripGroups={tripGroups} onReorder={reorderTripGroups} />
        </>
      )}
    </main>
  );
}

export default function Home() {
  return (
    <TripGroupsProvider>
      <MainPage />
    </TripGroupsProvider>
  );
}
