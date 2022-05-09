import LIST_ACTIONS from '../actions/listActions';

export const listReducer = (state, action) => {
    const actions = {
        [LIST_ACTIONS.LIST_FINDED]: listFinded.bind(this),
        [LIST_ACTIONS.LIST_DELETED]: listDeleted.bind(this),
        [LIST_ACTIONS.LIST_CREATED]: listCreated.bind(this),
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
    return { ...state, list: { items: [...state.list.items, payload] } };
};

