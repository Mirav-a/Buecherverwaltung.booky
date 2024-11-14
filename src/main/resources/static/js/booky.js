document.addEventListener("DOMContentLoaded", () => {
    loadBooks();
});

function loadBooks() {
    fetch('/Booky/api/books') // API-Pfad für das Laden aller Bücher
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById('bookList');
            bookList.innerHTML = ''; // Vorhandene Inhalte löschen
            data.forEach(book => {
                const bookDiv = document.createElement('div');
                bookDiv.classList.add('book');
                bookDiv.innerHTML = `
                    <h3>${book.title}</h3>
                    <p>Autor: ${book.author}</p>
                    <p>Preis: ${book.price} €</p>
                    <button onclick="buyBook(${book.id})" class="buy-button">Kaufen</button>
                `;
                bookList.appendChild(bookDiv);
            });
        })
        .catch(error => console.error('Fehler beim Laden der Bücher:', error));
}

function searchBooks() {
    const query = document.getElementById('searchInput').value;
    fetch(`/Booky/api/books/search?query=${query}`) // API-Pfad für die Suche
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById('bookList');
            bookList.innerHTML = ''; // Vorhandene Inhalte löschen
            data.forEach(book => {
                const bookDiv = document.createElement('div');
                bookDiv.classList.add('book');
                bookDiv.innerHTML = `
                    <h3>${book.title}</h3>
                    <p>Autor: ${book.author}</p>
                    <p>Preis: ${book.price} €</p>
                    <button onclick="buyBook(${book.id})" class="buy-button">Kaufen</button>
                `;
                bookList.appendChild(bookDiv);
            });
        })
        .catch(error => console.error('Fehler bei der Suche nach Büchern:', error));
}

function buyBook(bookId) {
    alert(`Buch mit der ID ${bookId} wurde gekauft!`); // Beispielhafte Kaufaktion
}
