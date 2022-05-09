import React from 'react';
import { StoreProvider } from '../application/store'
import { Lists } from './Lists';

export const App = () => {
    return <StoreProvider>
        <h3>Trabajo final</h3>
        <Lists />
    </StoreProvider>
}