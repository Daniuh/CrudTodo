import React, { useContext } from 'react';
import { Store } from '../application/store';
import listService from '../infraestructure/services/listService';
import LIST_ACTIONS from '../application/actions/listActions';

export const List = ({item}) => {
    const { state, dispatch } = useContext(Store);

    const deleteList = () => {
        listService.delete(item.id)
        .then(response => {
            if(response.ok){
                dispatch({type: LIST_ACTIONS.LIST_DELETED, payload: item.id});
            }
        });
    }
    return (
        <div className='list'>
            <span className='list__label'>
                <span>{item.label}</span>
                <button className='list__button' onClick={deleteList}>Eliminar</button>
            </span>
        </div>
    );
};