$(document).ready(function() {
			$.getJSON('http://localhost:8080/extension/all', function(json) {
				let tr=[];
				let cnt=0;
				for (let i = 0; i < json.length; i++) { //불러온데이터를 하나씩 노드화
                    if(json[i].type === 1) {
                        if(json[i].block){ //check 되어있는지 확인
                            tr.push(`<div class="checkbox"><input type="checkbox" onclick="updateExtension(event)" id="extension.${json[i].extensionId}" name="extension" checked />`)
                        }else{
                            tr.push(`<div class="checkbox"><input type="checkbox" onclick="updateExtension(event)" id="extension.${json[i].extensionId}" name="extension"/>`)
                        }
                        tr.push(`<label for="extension.${json[i].extensionId}"> ${json[i].name} </label></div>`);
                    }else{
                        $('#custom_list').append(`<div class="extension-list"><div>${json[i].name}</div><div id="extension.${json[i].extensionId}" class="close-btn" onclick="deleteExtension(this)">X</div></div>`)
                        cnt++;
                    }
                }
                $('#checkbox_list').append($(tr.join('')));
                $('#cnt_extensions').text(cnt)
			});
			})