import React, { useContext } from 'react';
import TODO_ACTIONS from '../../application/actions/todoActions';
import { Store } from '../../application/store';
import todoService from '../../infraestructure/services/todoService';

export const Todo = ({ todo }) => {
    const decorationDone = { textDecoration: 'line-through' };
    const { dispatch } = useContext(Store);
    const deleteTodo = () => {
        todoService.delete(todo.id)
            .then(response => {
                if (response.ok) {
                    dispatch({ type: TODO_ACTIONS.TODO_DELETED, payload: { todoId: todo.id, listId: todo.listId } });
                }
            })
    };

    const updateTodo = () => {
        dispatch({ type: TODO_ACTIONS.TODO_TO_UPDATE_SET_UP, payload: todo})
    };

    const updateIsCompleted = (event) => {
        const body = {...todo, isCompleted: event.target.checked}
        todoService.update(body)
        .then(response => response.json())
        .then(response => dispatch({type: TODO_ACTIONS.TODO_UPDATED, payload: response}))
    }

    return (
        <tr style={todo.isCompleted ? decorationDone : {}}>
            <td>{todo.label}</td>
            <td><input type="checkbox" defaultChecked={todo.isCompleted} onChange={updateIsCompleted}></input></td>
            <td><button onClick={deleteTodo}>Eliminar</button></td>
            <td><button onClick={updateTodo}>Editar</button></td>
        </tr>
    );
}