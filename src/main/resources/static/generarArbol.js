document.addEventListener("DOMContentLoaded", () =>{
    const btnArbolSintactico = document.getElementsByClassName('btn-arbol')[0];

    btnArbolSintactico.addEventListener('click', async () =>{
        const codigo = document.getElementById('editor-textarea').value;

        try{
            const respuesta = await fetch('http://localhost:8080/api/arbol' , {

                method: 'POST',
                headers: {
                     'Content-Type': 'text/plain'
                },
                body: codigo
            });

            if(!respuesta.ok){
                throw new Error('Error al generar el árbol sintáctico');
            }

            const data = await respuesta.json();
            console.log(data);
            renderizarArbol(data); 
        }catch(error){
            console.error("Error al obtener el árbol: " + error);
            alert("No se ha podido generar el árbol sintáctico")
        }
    });
});

function renderizarArbol(data) {
    const contenedor = document.getElementById('arbol');
    contenedor.innerHTML = '';

    const dx = 50;
    const dy = 100;      // espacio horizontal entre hermanos
    const margin = { top: 40, right: 40, bottom: 40, left: 40 };

    const tree = d3.tree().nodeSize([dx, dy]);
    const root = d3.hierarchy(data);
    tree(root);

    // Calcular dimensiones reales del árbol
    const width = root.height * dy + margin.left + margin.right;
    const height = root.descendants().length * dx + margin.top + margin.bottom;

    const svg = d3.select("#arbol")
        .append("svg")
        .attr("width", "100%")
        .attr("height", height)
        .attr("viewBox", [0, 0, width, height])
        .style("font", "12px sans-serif");

    const g = svg.append("g")
        .attr("transform", `translate(${width / 2}, ${margin.top})`); // ✅ centrado horizontal

    const diagonal = d3.linkVertical()
        .x(d => d.x)
        .y(d => d.y);

    // Enlaces
    g.append("g")
        .selectAll("path")
        .data(root.links())
        .join("path")
        .attr("fill", "none")
        .attr("stroke", "#555")
        .attr("stroke-opacity", 0.4)
        .attr("stroke-width", 1.5)
        .attr("d", diagonal);

    // Nodos
    const node = g.append("g")
        .selectAll("g")
        .data(root.descendants())
        .join("g")
        .attr("transform", d => `translate(${d.x},${d.y})`);

    node.append("circle")
        .attr("fill", d => d.children ? "#555" : "#999")
        .attr("r", 4);

    node.append("text")
        .attr("dy", "0.31em")
        .attr("x", d => d.children ? -8 : 8)
        .attr("text-anchor", d => d.children ? "end" : "start")
        .text(d => d.data.name || d.data.value)
        .clone(true).lower()
        .attr("stroke", "white");
}

