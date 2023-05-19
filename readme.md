# ���������� �� �������� ���������� ���� :
���������� ���������� �� jetpack compose. ���������� �������� � �������������� layouts.

## ���� ������������ ����������

<p  align="left">
<code><img width="5%" title="Compose" src="readme_files/icons_services/compose.png"></code>
<code><img width="5%" title="Git" src="readme_files/icons_services/git.png"></code>
<code><img width="5%" title="Gradle" src="readme_files/icons_services/gradle.png"></code>
<code><img width="5%" title="Kotlin" src="readme_files/icons_services/kotlin.png"></code>
<code><img width="5%" title="MVVM" src="readme_files/icons_services/mvvm.png"></code>
<code><img width="5%" title="Hilt" src="readme_files/icons_services/hilt.png"></code>

</p>

##  ���������� ������� � ����������

��� �������� � ������ ���� ������ �� ������ ```�������```

![](/readme_files/screens_app/main.png)

�� ���� ������ ����������� ��� ����� ����������� ��������.
��������������, ��� �� ���������� ����� ������������ �� ������������ �����, 
����� ������� �� ���� �� ����.

![](/readme_files/screens_app/all_letter.png)


�� ������ ������ ����, ���� ����� �� �����, ������ ���� � ������ ��� ���������� �����.

![](/readme_files/screens_app/all_words_letter.png)

���� �� ����� ����� ������� ����� �� ������, �� �� ������� ��� � ����� � ��� ������� 
��� ������� �� ������� �����.

![](/readme_files/screens_app/search_letter.png)

��� ���������� �����, ��� ����� ������� �� ������� � ������ ���� � ��������� ����. 
����� ���� �� ����� ���������.

![](/readme_files/screens_app/add_letter.png)

����� ��������� ����������� ����� ����� ������� � �������� ������ � ������ ```����������```.
��� ��� ������ ������� �������� ������������� ������� ��������� ���� ��� �����������.

![](/readme_files/screens_app/guess_word)

![](/readme_files/screens_app/guess_word2)

![](/readme_files/screens_app/guess_word3)

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