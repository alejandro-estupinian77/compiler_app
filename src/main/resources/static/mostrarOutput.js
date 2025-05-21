//Botones
const btnArbolSintactico = document.getElementsByClassName('btn-arbol')[0];
const btnTokens = document.getElementsByClassName('btn-tokens')[0];
const btnTabla = document.getElementsByClassName('btn-tabla')[0];
const btnErrores = document.getElementsByClassName('btn-errores')[0];
const btnEvaluador = document.getElementsByClassName('btn-evaluador')[0];

//Contenedores
const textAreaOutput = document.getElementById('output');
const contenedorArbol = document.getElementsByClassName('contenedor-arbol')[0];

btnArbolSintactico.addEventListener('click', () =>{
    textAreaOutput.style.display = 'none';
    contenedorArbol.style.display = 'block';
});

btnTokens.addEventListener('click', () =>{
    textAreaOutput.style.display = 'block';
    contenedorArbol.style.display = 'none';
}); 

btnTabla.addEventListener('click', () =>{
    textAreaOutput.style.display = 'block';
    contenedorArbol.style.display = 'none';
}); 

btnErrores.addEventListener('click', () =>{
    textAreaOutput.style.display = 'block';
    contenedorArbol.style.display = 'none';
}); 

btnEvaluador.addEventListener('click', () =>{
    textAreaOutput.style.display = 'block';
    contenedorArbol.style.display = 'none';
}); 