function ModalInfoUsers() {
    const modal = document.querySelector(".info-users + dialog");
    modal.showModal();
}

function ModalCategories() {
    const modal = document.querySelector(".categories + dialog");
    modal.showModal();
}

function ModalNotifications() {
    const modal = document.querySelector(".notifications + dialog");
    modal.showModal();
}

function BtnSaveModal() {
    const modals = document.querySelectorAll("dialog");
    modals.forEach((modal) => {
        modal.close();
    });
}

function BtnCloseModal() {
    const modals = document.querySelectorAll("dialog");
    modals.forEach((modal) => {
        modal.close();
    });
}