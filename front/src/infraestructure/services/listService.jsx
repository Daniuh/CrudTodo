import http from '../../environment/http'
import resourceUrl from '../../environment/resourceUrl'

export default {
    create: data => http.post(resourceUrl.list, data),
    delete: listId => http.delete(resourceUrl.deleteList(listId)),
    getAll: () => http.get(resourceUrl.list),
};