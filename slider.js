document.addEventListener("DOMContentLoaded", () => {
    // Функция для движения слайдов
    function move(panel, direction) {
        let objects = Array.from(panel.getElementsByClassName('popular_auto_item'));
        let translateWidth = objects[0].offsetWidth + 16; // Ширина одного элемента

        // Находим индекс элемента с классом item_big
        let bigIndex = objects.findIndex(item => item.classList.contains('item_big'));
        
        // Если сдвигаем вправо, элемент с item_big перемещается на следующую позицию
        if (direction === -1 && bigIndex < objects.length - 1) {
            // Двигаем вправо: передвигаем item_big в следующую позицию
            objects[bigIndex].classList.remove('item_big');
            objects[bigIndex + 1].classList.add('item_big');
        }
        // Если сдвигаем влево, элемент с item_big перемещается на предыдущую позицию
        if (direction === 1 && bigIndex > 0) {
            // Двигаем влево: передвигаем item_big в предыдущую позицию
            objects[bigIndex].classList.remove('item_big');
            objects[bigIndex - 1].classList.add('item_big');
        }

        // Смещаем элементы как карусель: передвигаем их влево или вправо
        if (direction === -1) {
            // Если сдвиг вправо, первый элемент уходит в конец
            let firstItem = objects.shift();
            panel.querySelector('.swipper').appendChild(firstItem); // Перемещаем первый элемент в конец
        } else if (direction === 1) {
            // Если сдвиг влево, последний элемент уходит в начало
            let lastItem = objects.pop();
            panel.querySelector('.swipper').insertBefore(lastItem, objects[0]); // Перемещаем последний элемент в начало
        }

        // Применяем трансформацию ко всем элементам
        objects.forEach(item => {
            item.style.transition = 'transform 0.5s'; // Плавный переход для сдвига
            item.style.transform = `translateX(0px)`; // Обнуляем трансформацию
        });
    }

    // Обработчик событий для всех панелей
    let panels = document.querySelectorAll('.popular_auto');
    panels.forEach(panel => {
        let swipper = panel.querySelector('.swipper');
        panel.swipper = swipper; // Присваиваем элемент слайдера

        // Обработчик кликов на панели
        panel.addEventListener('click', event => {
            let objects = panel.getElementsByClassName('popular_auto_item');
            let element_next = null;

            // Проверка на навигацию вправо
            if (event.target.classList.contains('nav_right')) {
                move(panel, -1); // Сдвиг вправо
            }

            // Проверка на навигацию влево
            if (event.target.classList.contains('nav_left')) {
                move(panel, 1); // Сдвиг влево
            }
        });
    });
});




document.addEventListener("DOMContentLoaded", () => {
    // Функция для движения слайдов
    function move(panel, direction) {
        let objects = Array.from(panel.getElementsByClassName('popular_auto_item'));
        let translateWidth = objects[0].offsetWidth + 16; // Ширина одного элемента

        // Находим индекс элемента с классом item_big
        let bigIndex = objects.findIndex(item => item.classList.contains('item_big'));
        
        // Если сдвигаем вправо, элемент с item_big перемещается на следующую позицию
        if (direction === -1 && bigIndex < objects.length - 1) {
            // Двигаем вправо: передвигаем item_big в следующую позицию
            objects[bigIndex].classList.remove('item_big');
            objects[bigIndex + 1].classList.add('item_big');
        }
        // Если сдвигаем влево, элемент с item_big перемещается на предыдущую позицию
        if (direction === 1 && bigIndex > 0) {
            // Двигаем влево: передвигаем item_big в предыдущую позицию
            objects[bigIndex].classList.remove('item_big');
            objects[bigIndex - 1].classList.add('item_big');
        }

        // Сдвигаем элементы, чтобы создать эффект карусели
        if (direction === -1) {
            // Если сдвиг вправо, первый элемент уходит в конец
            let firstItem = objects.shift();
            panel.querySelector('.swipper').appendChild(firstItem); // Перемещаем первый элемент в конец
        } else if (direction === 1) {
            // Если сдвиг влево, последний элемент уходит в начало
            let lastItem = objects.pop();
            panel.querySelector('.swipper').insertBefore(lastItem, objects[0]); // Перемещаем последний элемент в начало
        }

        // Применяем плавный сдвиг ко всем элементам
        objects.forEach(item => {
            item.style.transition = 'transform 0.5s'; // Плавный переход для сдвига
            item.style.transform = `translateX(0px)`; // Обнуляем трансформацию
        });
    }

    // Обработчик событий для всех панелей
    let panels = document.querySelectorAll('.popular_auto');
    panels.forEach(panel => {
        let swipper = panel.querySelector('.swipper');
        panel.swipper = swipper; // Присваиваем элемент слайдера

        // Обработчик кликов на панели
        panel.addEventListener('click', event => {
            let objects = panel.getElementsByClassName('popular_auto_item');

            // Проверка на навигацию вправо
            if (event.target.classList.contains('nav_right')) {
                move(panel, -1); // Сдвиг вправо
            }

            // Проверка на навигацию влево
            if (event.target.classList.contains('nav_left')) {
                move(panel, 1); // Сдвиг влево
            }
        });
    });
});

