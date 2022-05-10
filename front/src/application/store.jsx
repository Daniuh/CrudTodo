import React, { useReducer, createContext } from 'react';
import { reducer } from './reducers/reducer'

const initialState = {
  list: {
    items: [],
    todoToUpdated: {}
  }
};

export const Store = createContext(initialState);

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>
};