function ModalInput() {
    const modal = document.querySelector(".button-input + dialog");
    modal.showModal();
}

function ModalOutput() {
    const modal = document.querySelector(".button-output + dialog");
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