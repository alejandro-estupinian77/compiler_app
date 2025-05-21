const botonExportar = document.getElementsByClassName('btn-exportar')[0];
const editorCodigo = document.getElementById('editor-textarea');

botonExportar.addEventListener('click', function(){
    const codigo = editorCodigo.value;

    if (codigo != ""){
        const blob = new Blob([codigo], {type: "text/plaib"});
        const enlace = document.createElement("a");
        enlace.href = URL.createObjectURL(blob);
        enlace.download = "codigo_generado.txt";
        enlace.click();
    }else{
        alert("Escriba código para poder exportarlo.")
    }
    
})