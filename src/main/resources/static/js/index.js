const input = document.querySelector("#ext_input");
const customList = document.querySelector("#custom_list");
const form = document.querySelector("#add_form");


function createInputText() {
  const text = document.createElement("div");
  text.innerText = input.value;
  return text;
}

function createCloseButton() {
  const closeBtn = document.createElement("div");
  closeBtn.setAttribute('onclick','deleteExtension(this)')
  closeBtn.innerText = "X";
  closeBtn.className = "close-btn";
  return closeBtn;
}

function createExtension() {
      const newExtension = document.createElement("div");
      const closeBtn = createCloseButton();
      const text = createInputText();

      $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: `http://localhost:8080/extension/add?name=${$(text).text()}&isBlock=true&type=2`,
            cache: false,
            success: function(result) {
                closeBtn.id = `extension.${result}`;
                newExtension.className = "extension-list";
                newExtension.appendChild(text);
                newExtension.appendChild(closeBtn);
                $("#cnt_extensions").text(parseInt($("#cnt_extensions").text())+1)
            },
            error: function(err) {
                alert("서버 통신을 실패했습니다")
            }
      });
      return newExtension;
}

function updateExtension(e){
    const blockCheck = e.target.checked;
    const updateId = e.target.id.split(".")[1];
    $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: `http://localhost:8080/extension/update/${updateId}?isBlock=${blockCheck}`,
            cache: false,
            success: function(result) {

            },
            error: function(err) {
                alert("서버 통신을 실패했습니다")
            }
      });
}

function deleteExtension(e){
    const delId = e.id.split(".")[1];
    $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: `http://localhost:8080/extension/delete/${delId}`,
            cache: false,
            success: function(result) {
                window.location.reload()
            },
            error: function(err) {
                alert("서버 통신을 실패했습니다")
            }
      });
}

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const newExtension = createExtension();
  input.value = "";
  customList.appendChild(newExtension);
});
