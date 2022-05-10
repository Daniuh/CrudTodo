import LIST_ACTIONS from '../actions/listActions';
import TODO_ACTIONS from '../actions/todoActions';

export const reducer = (state, action) => {
    const actions = {
        [LIST_ACTIONS.LIST_FINDED]: listFinded.bind(this),
        [LIST_ACTIONS.LIST_DELETED]: listDeleted.bind(this),
        [LIST_ACTIONS.LIST_CREATED]: listCreated.bind(this),
        [TODO_ACTIONS.TODO_CREATED]: todoCreated.bind(this),
        [TODO_ACTIONS.TODO_DELETED]: todoDeleted.bind(this),
        [TODO_ACTIONS.TODO_UPDATED]: todoUpdated.bind(this),
        [TODO_ACTIONS.TODO_TO_UPDATE_SET_UP]: todoToUpdateSetUp.bind(this),
    }

    return actions[action.type](state, action.payload);
};

const listFinded = (state, payload) => {
    return { ...state, list: { items: payload } };
};

const listDeleted = (state, payload) => {
    const items = state.list.items.filter(item => item.id !== payload);
    return { ...state, list: { items } };
};

const listCreated = (state, payload) => {
    const newList = {...payload, todos: []}
    return { ...state, list: { items: [...state.list.items, newList] } };
};

const todoDeleted = (state, payload) => {
    const item = state.list.items.find(item => item.id === payload.listId);
    const items = state.list.items.filter(item => item.id !== payload.listId);
    const newItem = {...item, todos: item.todos.filter(todo => todo.id !== payload.todoId)}
    return { ...state, list: { items: [...items, newItem] } };
};

const todoCreated = (state, payload) => {
    const item = state.list.items.find(item => item.id === payload.listId);
    const items = state.list.items.filter(item => item.id !== payload.listId);
    const newItem = {...item, todos:[...item.todos, payload]}
    return { ...state, list: { items: [...items, newItem] } };
};

const todoUpdated = (state, payload) => {
    const item = state.list.items.find(item => item.id === payload.listId);
    const items = state.list.items.filter(item => item.id !== payload.listId);
    const todos = item.todos.filter(todo => todo.id !== payload.id);
    const newItem = {...item, todos:[...todos, payload]}
    return { ...state, list: { items: [...items, newItem] } };
};

const todoToUpdateSetUp = (state, payload) => {
    return { ...state, list: { ...state.list, todoToUpdate: payload}}
}