export async function getName() {
    return fetch('/api/get-name').then(response => response.json());
}

export async function getShortcuts() {
    return fetch('/api/get-shortcuts').then(response => response.json());
}

