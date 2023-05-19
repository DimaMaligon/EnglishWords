# ���������� �� �������� ���������� ���� :
���������� ���������� �� jetpack compose. ���������� �������� � �������������� layouts.

## ���� ������������ ����������

<p  align="left">
<code><img width="5%" title="IntelliJ IDEA" src="readmefiles/icons_services/compose.png"></code>
<code><img width="5%" title="Java" src="readmefiles/icons_services/git.png"></code>
<code><img width="5%" title="Gradle" src="readmefiles/icons_services/gradle.png"></code>
<code><img width="5%" title="GitHub" src="readmefiles/icons_services/kotlin.png"></code>
<code><img width="5%" title="GitHub" src="readmefiles/icons_services/mvvm.png"></code>
<code><img width="5%" title="GitHub" src="readmefiles/icons_services/hilt.png"></code>

</p>

##  ���������� ������� � ����������

��� �������� � ������ ���� ������ �� ������ ```�������```

![](/readme_resources/screen_app/main.png)

�� ���� ������ ����������� ��� ����� ����������� ��������.
��������������, ��� �� ���������� ����� ������������ �� ������������ �����, 
����� ������� �� ���� �� ����.

![](/readme_resources/screen_app/all_letter.png)


�� ������ ������ ����, ���� ����� �� �����, ������ ���� � ������ ��� ���������� �����.

![](/readme_resources/screen_app/all_words_letter.png)

���� �� ����� ����� ������� ����� �� ������, �� �� ������� ��� � ����� � ��� ������� 
��� ������� �� ������� �����.

![](/readme_resources/screen_app/search_letter.png)

��� ���������� �����, ��� ����� ������� �� ������� � ������ ���� � ��������� ����. 
����� ���� �� ����� ���������.

![](/readme_resources/screen_app/add_letter.png)

����� ��������� ����������� ����� ����� ������� � �������� ������ � ������ ```����������```.
��� ��� ������ ������� �������� ������������� ������� ��������� ���� ��� �����������.

![](/readme_resources/screen_app/guess_word)

![](/readme_resources/screen_app/guess_word2)

![](/readme_resources/screen_app/guess_word3)

## �������� ������ �������
`LetterListScreen.kt` - ���������� LazyVerticalGrid, �����, ��� ��� ����� ��������� ������ � ���������� �������.
� ��� ���� �� ������, ����� ����������� ��������������� ����� �����.

`LetterScreen.kt` - �����, ������� ����������� ��� ���� �� ����� ��������� ������. 
���, �� ����� �������� ����� ����� � ��� ������� � ���� ������. ����������� ����� ����������� 
� ������ ����, ����� ����������.

`ErrorScreen.kt` -  ����� ������, ����������, ���� � ��� �������� �������� � �������� ������ �����.

`RepeatWordsScreen.kt` - ����� ���������� ���������� ����. ����� ������������� 4 
�������� ����� �� ����� � ������ ���� ������� ����������.
���� �� ������� �����, �� ������� ��������� ���� ����������, ���� ���, �� ���������� ������� ����������� ����.

`package db` - ��� ������ ��� ������ � ��
`MyDataBase`- ��������� � ������� ������, ��������, �������� �� �������� � �������� ������.
`DbHelper` - ����� ��� �������� � ���������� ������ � ��
`MyDbManager` - - ����� ��� ���������� ��

`package data` - c����� ���� ����������� ��������

`package app` - ������ ���� ���������� Application ��� ���������� ���������� dagger2 ������.

`package navigation` - ��������� �� ������� ����������
`Screens.kt` - �������� ����� �������
`NavGraph.kt` - ���������� � ��������� ������� � ������, ����� ����� ����� ���� ��������� � ������ ����� navigation.

`package di.module` ����� ��� ������ � �������������
`class AppModule` - �������� ����������� ��������