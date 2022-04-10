export async function addShortcut(name, desc, icon, url, keymap, groupId) {
    const response = await fetch(`/api/add-shortcut`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, body: JSON.stringify({
            name: name,
            desc: desc,
            headerUrl: icon,
            url: url,
            key: keymap,
            groupId: groupId
        })
    });
    const data = await response.json();
    return data;
}