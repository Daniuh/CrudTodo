import React, { useReducer, createContext } from 'react';
import { listReducer } from './reducers/listReducer'

const initialState = {
  list: {
    items: [],
  }
};

export const Store = createContext(initialState);

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(listReducer, initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>
};