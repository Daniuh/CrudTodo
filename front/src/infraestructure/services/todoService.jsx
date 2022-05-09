import http from '../../environment/http'
import resourceUrl from '../../environment/resourceUrl'

export default {
    create: data => http.post(resourceUrl.todo, data),
    delete: todoId => http.delete(resourceUrl.deleteTodo(todoId)),
    update: data => http.put(resourceUrl.todo, data),
};