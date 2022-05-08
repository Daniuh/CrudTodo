export default {
    post: (url, body) => fetch(url, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: { 'Content-Type': 'application/json' }
    }),
    put: (url, body) => fetch(url, {
        method: 'PUT',
        body: JSON.stringify(body),
        headers: { 'Content-Type': 'application/json' }
    }),
    get: (url) => fetch(url, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    }),
    delete: (url) => fetch(url, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    }),
};

