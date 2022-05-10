import React from 'react';
import { StoreProvider } from '../application/store'
import { Lists } from './list/Lists';

export const App = () => {
    return <StoreProvider>
        <center>
            <h1>Trabajo final</h1><br />
        </center>
        <Lists />
    </StoreProvider>
}