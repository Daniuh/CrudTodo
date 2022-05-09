import env from "./environment";

export default {
    todo: `${env.apiUrl}/todo`,
    list: `${env.apiUrl}/list`,
    deleteList: listId => `${env.apiUrl}/list/${listId}`,
    deleteTodo: todoId => `${env.apiUrl}/todo/${todoId}`,
}