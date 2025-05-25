document.addEventListener('DOMContentLoaded', function() {
    // Verifica se o elemento .cinema-elements existe na página
    const backgroundElements = document.querySelector('.cinema-elements');
    if (!backgroundElements) return;

    // Criar rolos de filme
    for (let i = 0; i < 5; i++) {
        createFilmReel(backgroundElements);
    }

    // Criar faixas de filme
    for (let i = 0; i < 8; i++) {
        createFilmStrip(backgroundElements);
    }

    // Criar holofotes
    for (let i = 0; i < 3; i++) {
        createSpotlight(backgroundElements);
    }

    // Criar estrelas
    for (let i = 0; i < 50; i++) {
        createStar(backgroundElements);
    }

    // Adicionar textos BR FILMES decorativos
    addBrFilmesTexts(backgroundElements);
});

// Função para criar rolos de filme
function createFilmReel(container) {
    const reel = document.createElement('div');
    reel.classList.add('cinema-element', 'film-reel');

    // Tamanho aleatório entre 100px e 300px
    const size = Math.floor(Math.random() * 200) + 100;
    reel.style.width = `${size}px`;
    reel.style.height = `${size}px`;

    // Posição aleatória na tela
    const left = Math.floor(Math.random() * 100);
    const top = Math.floor(Math.random() * 100);
    reel.style.left = `${left}%`;
    reel.style.top = `${top}%`;

    // Opacidade aleatória
    const opacity = (Math.random() * 0.10) + 0.05;
    reel.style.opacity = opacity;

    // Animação com atraso aleatório
    const animationDuration = (Math.random() * 20) + 20;
    const animationDelay = Math.random() * 2;
    reel.style.animationDuration = `${animationDuration}s`;
    reel.style.animationDelay = `${animationDelay}s`;

    container.appendChild(reel);
}

// Função para criar faixas de filme
function createFilmStrip(container) {
    const strip = document.createElement('div');
    strip.classList.add('cinema-element', 'film-strip');

    // Largura aleatória entre 100px e 400px
    const width = Math.floor(Math.random() * 300) + 100;
    strip.style.width = `${width}px`;

    // Posição aleatória na tela
    const left = Math.floor(Math.random() * 100);
    const top = Math.floor(Math.random() * 100);
    strip.style.left = `${left}%`;
    strip.style.top = `${top}%`;

    // Rotação aleatória
    const rotation = Math.floor(Math.random() * 180) - 90;
    strip.style.transform = `rotate(${rotation}deg)`;

    // Opacidade aleatória
    const opacity = (Math.random() * 0.15) + 0.05;
    strip.style.opacity = opacity;

    container.appendChild(strip);
}

// Função para criar holofotes
function createSpotlight(container) {
    const spotlight = document.createElement('div');
    spotlight.classList.add('cinema-element', 'spotlight');

    // Tamanho aleatório entre 200px e 500px
    const size = Math.floor(Math.random() * 300) + 200;
    spotlight.style.width = `${size}px`;
    spotlight.style.height = `${size}px`;

    // Posição aleatória na tela
    const left = Math.floor(Math.random() * 100);
    const top = Math.floor(Math.random() * 100);
    spotlight.style.left = `${left}%`;
    spotlight.style.top = `${top}%`;

    // Opacidade aleatória
    const opacity = (Math.random() * 0.1) + 0.1;
    spotlight.style.opacity = opacity;

    // Animação com atraso aleatório
    const animationDuration = (Math.random() * 5) + 5;
    const animationDelay = Math.random() * 2;
    spotlight.style.animationDuration = `${animationDuration}s`;
    spotlight.style.animationDelay = `${animationDelay}s`;

    container.appendChild(spotlight);
}

// Função para criar estrelas
function createStar(container) {
    const star = document.createElement('div');
    star.classList.add('cinema-element', 'star');

    // Posição aleatória na tela
    const left = Math.floor(Math.random() * 100);
    const top = Math.floor(Math.random() * 100);
    star.style.left = `${left}%`;
    star.style.top = `${top}%`;

    // Tamanho aleatório
    const size = Math.random() * 3 + 1;
    star.style.width = `${size}px`;
    star.style.height = `${size}px`;

    // Brilho aleatório
    const opacity = Math.random() * 0.7 + 0.3;
    star.style.opacity = opacity;

    // Animação com atraso aleatório
    const animationDuration = Math.random() * 3 + 2;
    const animationDelay = Math.random() * 5;
    star.style.animationDuration = `${animationDuration}s`;
    star.style.animationDelay = `${animationDelay}s`;

    container.appendChild(star);
}

// Função para adicionar textos BR FILMES decorativos
function addBrFilmesTexts(container) {
    const brFilmesTexts = [
        { size: 150, x: '10%', y: '15%', rotation: -15, opacity: 0.08 },
        { size: 200, x: '75%', y: '80%', rotation: 10, opacity: 0.1 },
        { size: 180, x: '60%', y: '25%', rotation: 5, opacity: 0.07 },
        { size: 120, x: '25%', y: '60%', rotation: -8, opacity: 0.09 },
        { size: 90, x: '40%', y: '40%', rotation: 12, opacity: 0.08 },
        { size: 160, x: '85%', y: '35%', rotation: -5, opacity: 0.07 }
    ];

    brFilmesTexts.forEach(item => {
        const text = document.createElement('div');
        text.classList.add('cinema-element');
        text.textContent = 'BR FILMES';
        text.style.fontSize = `${item.size}px`;
        text.style.fontWeight = 'bold';
        text.style.left = item.x;
        text.style.top = item.y;
        text.style.opacity = item.opacity;
        text.style.transform = `rotate(${item.rotation}deg)`;
        text.style.color = 'rgba(229, 9, 20, 0.2)';
        container.appendChild(text);
    });
}
