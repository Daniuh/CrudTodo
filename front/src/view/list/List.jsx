import React, { useContext, useState, useRef } from 'react';
import { Store } from '../../application/store';
import listService from '../../infraestructure/services/listService';
import LIST_ACTIONS from '../../application/actions/listActions';
import { Todo } from '../todo/Todo';
import { v4 as uuidv4 } from 'uuid';
import TODO_ACTIONS from '../../application/actions/todoActions';
import service from '../../infraestructure/services/todoService';

export const List = ({ item }) => {
    const { dispatch } = useContext(Store);
    const formRef = useRef(null);
    const [todoName, setTodoName] = useState();
    
    const createTodo = (event) => {
        event.preventDefault();
        const body = { id: uuidv4(), label: todoName, isCompleted: false, listId: item.id};
        service.create(body)
            .then(response => response.json())
            .then(response => {
                dispatch({ type: TODO_ACTIONS.TODO_CREATED, payload: response });
                formRef.current.reset();
            })
    };

    const deleteList = () => {
        listService.delete(item.id)
            .then(response => {
                if (response.ok) {
                    dispatch({ type: LIST_ACTIONS.LIST_DELETED, payload: item.id });
                }
            });
    }

    return (
        <div className='list'>
            <span className='list__label'>
                <span>{item.label}</span>
                <button className='list__button' onClick={deleteList}>Eliminar</button>
            </span>
            <form ref={formRef}>
                <input type="text" placeholder="Nombre de la lista" onChange={(event) => setTodoName(event.target.value)} />
                <button className='list__button' onClick={createTodo} >Crear</button>
            </form>
            <table >
                <thead>
                    <tr>
                        <td>Tarea</td>
                        <td>¿Completado?</td>
                    </tr>
                </thead>
                <tbody>
                    {item.todos && item.todos.map((todo) => <Todo key={todo.id} todo = {todo}/>)}
                </tbody>
            </table>
        </div>
    );
};