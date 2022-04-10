export async function getGroups() {
  const response = await fetch(`/api/get-groups`);
  const data = await response.json();
  return data;
}

export async function addGroup(name) {
  const response = await fetch(`/api/add-group/`+name, {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }});
  const data = await response.json();
  return data;
}

export async function updateGroup(id, name) {
  const response = await fetch(`/api/update-group/`+id+`/`+name, {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }});
  const data = await response.json();
  return data;
}

export async function deleteGroup(id) {
  const response = await fetch(`/api/delete-group/`+id, {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }});
  const data = await response.json();
  return data;
}