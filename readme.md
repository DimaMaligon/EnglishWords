# ���������� �� �������� ���������� ���� :
���������� ���������� �� jetpack compose. ���������� �������� � �������������� layouts.

## ���� ������������ ����������

<p  align="left">
<code><img width="5%" title="Compose" src="readme_files/icons_services/compose.png"></code>
<code><img width="5%" title="Git" src="readme_files/icons_services/github.png"></code>
<code><img width="5%" title="Gradle" src="readme_files/icons_services/gradle.png"></code>
<code><img width="5%" title="Kotlin" src="readme_files/icons_services/kotlin.png"></code>
<code><img width="5%" title="MVVM" src="readme_files/icons_services/mvvm.png"></code>
<code><img width="5%" title="Hilt" src="readme_files/icons_services/hilt.png"></code>

</p>

##  ���������� ������� � ����������

��� �������� � ������ ���� ������ �� ������ ```�������```

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/main.png"></code>
</p>

�� ���� ������ ����������� ��� ����� ����������� ��������.
��������������, ��� �� ���������� ����� ������������ �� ������������ �����, 
����� ������� �� ���� �� ����.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/all_letter.png"></code>
</p>

�� ������ ������ ����, ���� �����, ������ ���� � ������ ��� ���������� �����.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/all_words_letter.png"></code>
</p>

���� �� ����� ����� ������� ����� �� ������, �� �� ������� ��� � ����� � ��� ������� 
��� ������� �� ������� �����.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/search_letter.png"></code>
</p>

��� ���������� �����, ��� ����� ������� �� ������� � ������ ���� � ��������� ����. 
����� ���� �� ����� ��� ���������.

<p  align="center">
<code><img width="30%" title="Hilt" src="readme_files/screens_app/add_letter.png"></code>
</p>

����� ��������� ����������� ����� ����� ������� � �������� ������ � ������ ```����������```.
��� ��� ������ ������� �������� ������������� ������� ��������� ���� ��� �����������.

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word".png></code>
</p>

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word2".png></code>
</p>

<p  align="center">
<code><img width="30%" src="readme_files/screens_app/guess_word3".png></code>
</p>

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