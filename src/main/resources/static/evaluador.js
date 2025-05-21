document.addEventListener("DOMContentLoaded", () =>{
    const btnEvaluar = document.getElementsByClassName('btn-evaluador')[0];
    const outputArea = document.getElementById('output');
    const editorArea = document.getElementById('editor-textarea');

    btnEvaluar.addEventListener('click', async () => {
        const codigo = editorArea.value;

        try{
            const respuesta = await fetch("http://localhost:8080/api/evaluar", {
                method: "POST",
                headers: {
                    "Content-Type": "text/plain"
                },
                body: codigo
            });

            if(!respuesta.ok){
                const errorData = await respuesta.json();
                outputArea.value = errorData.error;
                return;
            }

            const resultado = await respuesta.json();
            const resultadoTexto = Object.entries(resultado).map(([clave, valor]) => `${clave} = ${valor}`).join("\n");

            outputArea.value = `==Evaluación==\n${resultadoTexto}`;
        }catch(error){
            console.error(error);
            outputArea.value = "Error al evaluar la expresión";
        }
    })
});