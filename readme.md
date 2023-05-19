# Приложение по изучению Английских слов :
Приложение переведено на jetpack compose. Изначально писалось с использованием layouts.

## Стек используемых технологий

<p  align="left">
<code><img width="5%" title="Compose" src="readme_files/icons_services/compose.png"></code>
<code><img width="5%" title="Git" src="readme_files/icons_services/github.png"></code>
<code><img width="5%" title="Gradle" src="readme_files/icons_services/gradle.png"></code>
<code><img width="5%" title="Kotlin" src="readme_files/icons_services/kotlin.png"></code>
<code><img width="5%" title="MVVM" src="readme_files/icons_services/mvvm.png"></code>
<code><img width="5%" title="Hilt" src="readme_files/icons_services/hilt.png"></code>

</p>

##  Реализация словаря в приложении

Для перехода к списку слов тапаем на кнопку ```Словарь```

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/main.png"></code>
</p>

На этом экране перечислены все буквы английского алфавита.
Соответственно, что бы посмотреть слова начинающиеся на определенную букву, 
нужно тапнуть на одну из букв.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/all_letter.png"></code>
</p>

На экране Списка слов, есть поиск, список слов и кнопка для добавления слова.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/all_words_letter.png"></code>
</p>

Если мы хотим найти перевод слова из списка, то мы вбиваем его в поиск и нам выводит 
его перевод на русском языке.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/search_letter.png"></code>
</p>

Для добавления слова, нам нужно тапнуть на крестик в правом углу и заполнить поля. 
После чего мы можем его сохранить.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/add_letter.png"></code>
</p>

Чтобы повторить добавленные слова нужно перейти с главного экрана в раздел ```Упражнения```.
Тут при выборе верного варианта увеличивается счетчик Угаданных слов или Неугаданных.

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word".png></code>
</p>

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word2".png></code>
</p>

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word3".png></code>
</p>

## Описание файлов проекта
`LetterListScreen.kt` - реализация LazyVerticalGrid, решил, что так проще прокинуть кнопки с английским буквами.
А при тапе на кнопку, будет открываться соответствующий экран буквы.

`LetterScreen.kt` - экран, который открывается при тапе на любую буквенную кнопку. 
Тут, мы можем добавить новое слово и его перевод в базу данных. Добавленное слово отобразится 
в списке слов, после добавления.

`ErrorScreen.kt` -  экран ошибки, появляется, если у нас возникли проблемы с открытие экрана буквы.

`RepeatWordsScreen.kt` - экран повторения английских слов. Экран предоставляет 4 
перевода слова на выбор и только один перевод правильный.
Если вы угадали слово, то счетчик угаданных слов измениться, если нет, то измениться счетчик неугаданных слов.

`package db` - тут классы для работы с БД
`MyDataBase`- константы с именами таблиц, столбцов, запросов на создание и удаление таблиц.
`DbHelper` - класс для создания и обновления таблиц в бд
`MyDbManager` - - класс для управления бд

`package data` - cписок букв английского алфавита

`package app` - делаем свою реализацию Application для добавления библиотеки dagger2 хилтом.

`package navigation` - навигация по экранам приложения
`Screens.kt` - описание рутов экранов
`NavGraph.kt` - добавление и свзывание экранов с рутами, чтобы потом можно было добраться к экрану через navigation.

`package di.module` пакет для работы с зависимостями
`class AppModule` - создание экземпляров объектов