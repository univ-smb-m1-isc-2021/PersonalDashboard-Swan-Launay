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

export async function updateShortcut(shortcutId, name, description, icon, url, keyMap){
    const response = await fetch(`/api/update-shortcut/${shortcutId}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, body: JSON.stringify({
            name: name,
            desc: description,
            headerUrl: icon,
            url: url,
            key: keyMap
        })
    });
    const data = await response.json();
    return data;
}

export async function removeShortcut(shortcutId){
    const response = await fetch(`/api/remove-shortcut/${shortcutId}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    });
    const data = await response.json();
    return data;
}


let pointIsPressed = false;

document.addEventListener("keydown", (e) => {
    if(e.key === ".") {
        pointIsPressed = true;
    }
});

document.addEventListener("keyup", (e) => {
    if(e.key === ".") {
        pointIsPressed = false;
    }
});

export function keyMapListener(keymapList) {
    document.addEventListener("keydown", (e) => {
        if(pointIsPressed && e.key !== ".") {
            keymapList.forEach(keymap => {
                if(e.key.toUpperCase() === keymap.key.toUpperCase()) {
                    window.open(keymap.url, "_blank");
                    pointIsPressed = false;
                }
            });
        }
    });
}