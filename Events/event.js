document.getElementById('start-button').addEventListener('click', () => {
    const width = parseInt(document.getElementById('width').value);
    const growthAmount = parseInt(document.getElementById('growth-amount').value);
    const growRate = parseInt(document.getElementById('grow-rate').value);
    const numberCircles = parseInt(document.getElementById('number-circles').value);
    const container = document.getElementById('circle-container');
    container.innerHTML = '';

    for (let i = 0; i < numberCircles; i++) {
        createCircle(width, growthAmount, growRate, container);
    }
});

function createCircle(initialWidth, growthAmount, growRate, container) {
    const circle = document.createElement('div');
    circle.className = 'circle';
    circle.style.width = `${initialWidth}px`;
    circle.style.height = `${initialWidth}px`;

    const containerWidth = container.clientWidth;
    const containerHeight = container.clientHeight;
    const maxX = containerWidth - initialWidth;
    const maxY = containerHeight - initialWidth;
    const randomX = Math.random() * maxX;
    const randomY = Math.random() * maxY;

    circle.style.left = `${randomX}px`;
    circle.style.top = `${randomY}px`;

    container.appendChild(circle);

    const intervalId = setInterval(() => {
        const currentWidth = parseInt(circle.style.width);
        const newWidth = currentWidth + growthAmount;
        circle.style.width = `${newWidth}px`;
        circle.style.height = `${newWidth}px`;
    }, growRate);

    circle.addEventListener('click', () => {
        clearInterval(intervalId);
        circle.remove();
    });
}
