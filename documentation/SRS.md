# Требования к проекту
---

# Содержание
1 [Введение](#intro)  
1.1 [Назначение](#appointment)  
1.2 [Бизнес-требования](#business_requirements)  
1.2.1 [Исходные данные](#initial_data)  
1.2.2 [Возможности бизнеса](#business_opportunities)  
1.2.3 [Границы проекта](#project_boundary)  
1.3 [Аналоги](#analogues)  
2 [Требования пользователя](#user_requirements)  
2.1 [Программные интерфейсы](#software_interfaces)  
2.2 [Интерфейс пользователя](#user_interface)  
2.3 [Характеристики пользователей](#user_specifications)  
2.3.1 [Классы пользователей](#user_classes)  
2.3.2 [Аудитория приложения](#application_audience)  
2.3.2.1 [Целевая аудитория](#target_audience)  
2.3.2.1 [Побочная аудитория](#collateral_audience)  
2.4 [Предположения и зависимости](#assumptions_and_dependencies)  
3 [Системные требования](#system_requirements)  
3.1 [Функциональные требования](#functional_requirements)  
3.1.1 [Основные функции](#main_functions)  
3.1.1.1 [Вход пользователя в приложение](#user_logon_to_the_application)  
3.1.1.2 [Настройка профиля активного пользователя](#setting_up_the_profile_of_the_active_user)  
3.1.1.3 [Загрузка новостей](#download_news)  
3.1.1.4 [Просмотр информации об отдельной новости](#view_information_about_an_individual_newsletter)  
3.1.1.5 [Выход пользователя из учётной записи](#active_user_change)  
3.1.1.6 [Регистрация нового пользователя после входа в приложение](#add_new_user)  
3.1.2 [Ограничения и исключения](#restrictions_and_exclusions)  
3.2 [Нефункциональные требования](#non-functional_requirements)  
3.2.1 [Атрибуты качества](#quality_attributes)  
3.2.1.1 [Требования к удобству использования](#requirements_for_ease_of_use)    
3.2.1.2 [Требования к безопасности](#security_requirements)  
3.2.1.3 [Требования к доступности](#access_requirements)  
3.2.2 [Внешние интерфейсы](#external_interfaces)  
3.2.3 [Ограничения](#restrictions)

<a name="intro"/>

# 1 Введение

<a name="appointment"/>

## 1.1 Назначение
Данный документ содержит функциональные и нефункциональные требования к приложению "HeartHunter" - приложению для знакомств на платформе Android. Документ предназначен для команды разработчиков, ответственных за создание и проверку корректной работы приложения.

<a name="business_requirements"/>

## 1.2 Бизнес-требования

<a name="initial_data"/>

### 1.2.1 Исходные данные
В современном мире множество людей ищут новые знакомства и партнеров через мобильные приложения для знакомств. С этой целью пользователи ищут приложения, которые предоставляют им удобные и эффективные инструменты для знакомств. Они хотят иметь возможность находить интересных и подходящих кандидатов для знакомства, обмениваться сообщениями и находить своих спутников в жизни.

<a name="business_opportunities"/>

### 1.2.2 Возможности бизнеса
Приложение "HeartHunter" будет предоставлять пользователям следующие возможности:

Регистрация и создание профиля с базовой информацией о себе. Просмотр профилей других пользователей. Поиск пользователей на основе критериев, таких как интересы, местоположение и возраст. Инициирование контакта и обмен сообщениями с другими пользователями. Организация свиданий и встреч через приложение. Приложение будет предоставлять удобный и интуитивно понятный интерфейс, который будет привлекателен для разнообразных пользователей.

<a name="project_boundary"/>

### 1.2.3 Границы проекта

Границы проекта приложения "HeartHunter" включают в себя следующее:

-Платформа и ОС: Приложение разрабатывается исключительно для операционной системы Android и не будет доступно на других платформах, таких как iOS или веб-приложения.
-Географическая ограниченность: Первоначально приложение будет доступно только в определенных географических регионах или странах, определенных разработчиками. Расширение доступности приложения будет производиться по мере необходимости.
-Языковая поддержка: Приложение будет поддерживать ограниченное число языков, которые будут определены на этапе разработки. Добавление новых языков потребует дополнительной работы.
-Функциональные ограничения: Приложение "HeartHunter" будет ориентировано исключительно на функции и возможности, связанные с знакомствами и общением между пользователями. Оно не будет включать в себя функциональность, не связанную с целью знакомства и общения.
-Безопасность и конфиденциальность: Приложение будет предоставлять определенные меры безопасности и конфиденциальности для пользователей, но оно не может гарантировать абсолютную защиту данных или безопасность внешних действий пользователей.
-Технические ограничения: Приложение будет требовать определенные технические характеристики устройств Android для его нормальной работы, и некоторые старые устройства могут быть несовместимы с ним.

<a name="analogues"/>

## 1.3 Аналоги
Существует множество аналогичных приложений для знакомств, таких как Tinder, Bumble и OkCupid. Эти приложения предоставляют пользователям схожий функционал, позволяя им находить партнеров для знакомств на основе различных критериев. Благодаря им, пользователи могут расширить свой круг общения и найти подходящих кандидатов для знакомства.
### 1.3.1 Сравнение аналогов
| Название аналога | Недостатки                                                                                                                                                                                                |
|:---|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Tinder | Направленность действий на удержание пользователей в приложении, путем ухудшения алгоритмов поиска. Ограниченное количество лайков и невозможность вернуться к предыдущему аккаунту без платной подписки. |
| Мята | Сильно устаревший интерфейс, невозможность удалить аккаунт в течении двух суток после отправки запроса на удаление.                                                                                       |
| YouLove | Полное отсутствие продвинутых алгоритмов, интуитивно непонятный интерфейс.                                                                                                                                |

<a name="user_requirements"/>

# 2 Требования пользователя

<a name="software_interfaces"/>

## 2.1 Программные интерфейсы
Приложение использует API мессенджеров, API уведомлений.

<a name="user_interface"/>

## 2.2 Интерфейс пользователя
Окно входа в приложение.


![Окно входа в приложение](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Log%20in.png)

Окно регистрации нового пользователя.


![Окно регистрации нового пользователя](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Sign%20up%201.png)

Окно регистрации нового пользователя после ввода имени, электронной почты, пароля и даты рождения.

![Окно регистрации нового пользователя после ввода имени, электронной почты, пароля и даты рождения](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Sign%20up%202.png)

Главное окно приложения.

![Главное окно приложения](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Home%20page.png)

Окно профиля.

![Окно профиля](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Profile%20page.png)

Окно списка диалогов.

![Окно списка диалогов](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Message%20page.png)

Окно диалога.

![Окно диалога](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Chat%20page.png)

Окно уведомлений.

![Окно уведомлений](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Notification%20page.png)

Окно совпадений.

![Окно совпадений](https://github.com/helistam/HeartHunter/blob/main/images/mockups/Match%20page.png)


<a name="user_specifications"/>

## 2.3 Характеристики пользователей

<a name="user_classes"/>

### 2.3.1 Классы пользователей

| Класс пользователей | Описание |
|:---|:---|
| Зарегистрированные пользователи | Пользователи, которые вошли в приложение под своим именем, желающие просматривать информацию о любимых фильмах, отобранных согласно их предпочтениям, и добавлять к ним отзывы. Имеют доступ к полному функционалу|
| Администраторы | Пользователи, которые имеют доступ к панели администратора, видят жалобы зарегистрированных пользователей и реагируют на них, подтверждают аккаунты|

<a name="application_audience"/>

### 2.3.2 Аудитория приложения

<a name="target_audience"/>

#### 2.3.2.1 Целевая аудитория

Люди, активно ищущие новые знакомства и партнеров.

<a name="collateral_audience"/>

#### 2.3.2.2 Побочная аудитория
Люди, проводящие свое время разнообразными способами и не обязательно ориентированные на знакомства. Это включает в себя:

-Людей, которые могут использовать приложение для общения и обмена мнениями на различные темы.
-Людей, которые могут быть временно не заинтересованы в знакомствах, но могут использовать приложение для поиска новых знакомых в будущем.

<a name="assumptions_and_dependencies"/>

## 2.4 Предположения и зависимости
1. Приложение "HeartHunter" не может функционировать без подключения к интернету для обновления и получения данных о пользователях и их профилях.
2. Для просмотра информации о других пользователях и осуществления контакта пользователю необходимо зарегистрироваться.
3. Пользователи приложения "HeartHunter" должны быть готовы предоставить базовую информацию о себе при создании профиля для успешного использования приложения.
4. Для корректной работы и обеспечения безопасности пользователей, приложение будет выполнять проверки на соответствие правилам и политике использования, а также может использовать механизмы фильтрации и модерации контента.

<a name="system_requirements"/>

# 3 Системные требования

<a name="functional_requirements"/>

## 3.1 Функциональные требования

<a name="main_functions"/>

### 3.1.1 Основные функции

<a name="user_logon_to_the_application"/>

#### 3.1.1.1 Вход пользователя в приложение
**Описание.** Пользователь имеет возможность использовать приложение войдя в свою учётную запись.

| Функция | Требования | 
|:---|:---|
| <a name="registration_requirements"/>Регистрация нового пользователя | Приложение должно запросить у пользователя ввести имя и электронную почту для создания учётной записи. Пользователь должен либо ввести имя, либо отменить действие |
| Вход зарегистрированного пользователя в приложение | Пользователь должен ввести электронную почту введнную при создании аккаунта, либо отменить действие |

<a name="setting_up_the_profile_of_the_active_user"/>

#### 3.1.1.2 Настройка профиля активного пользователя
**Описание.** Зарегистрированный пользователь имеет возможность просматривать анкеты других пользователей.

| Функция | Требования | 
|:---|:---|
| Переход к следующей анкете | Приложение должно предоставить зарегистрированному пользователю возможность просматривать анкеты пользователей посредством жеста "свайп влево" либо "свайп вправо" |
| Просмотр предыдущей анкеты | Зарегистрированный пользователь имеет возможность вернуться к предыдущей анкете посредством нажатия на кнопку "🔙" |

<a name="download_news"/>

#### 3.1.1.3 Загрузка анкет
После входа пользователя в приложение или завершения редактирования профиля зарегистрированным пользователем, система автоматически загружает необходимое количество анкет. Это обеспечивает бесперебойную работу приложения даже в случае временных сбоев в интернет-соединении, не прерывая комфортного использования пользователем.

| Функция | Требования | 
|:---|:---|
| Загрузка анкет | Приложение должно загрузить несколько анкет после входа в приложение |

<a name="view_information_about_an_individual_newsletter"/>

#### 3.1.1.4 Просмотр информации об отдельной анкете
**Описание.** Пользователь имеет возможность просмотреть дополнительную информацию о каждой анкете.

| Функция | Требования | 
|:---|:---|
| Просмотр информации о анкете | Пользователь имеет возможность выбрать анкету жестом "свайп вправо". Приложение должно открыть окно, содержащее полную информацию о пользователе.|

<a name="active_user_change"/>

#### 3.1.1.5 Выход зарегистрированного пользователя из учётной записи
**Описание.** Зарегистрированный пользователь имеет возможность выйти из учётной записи.

| Функция | Требования | 
|:---|:---|
| Выход из учётной записи | Приложение должно предоставить зарегистрированному пользователю возможность выйти из учётной записи с возвратом к окну входа в приложение. |  

<a name="add_new_user"/>

#### 3.1.1.6 Регистрация нового пользователя после входа в приложение
**Описание.** Посетитель имеет возможность зарегистрироваться в приложении.

**Требование.** Приложение должно предоставить посетителю возможность [зарегистрироваться в приложении](#registration_requirements).

<a name="restrictions_and_exclusions"/>

### 3.1.2 Ограничения и исключения
1. Приложение может добавлять новые анкеты только при наличии подключения к Интернету;
2. Переписка с другим пользователем доступна только при условии его согласия.Это означает что ему предлагается ваша анкета и если она его устраивает, то он дает согласие на переписку и у вас появляется функция чата с данным пользователем.

<a name="non-functional_requirements"/>

## 3.2 Нефункциональные требования

<a name="quality_attributes"/>

### 3.2.1 Атрибуты качества

<a name="requirements_for_ease_of_use"/>

#### 3.2.1.1 Требования к удобству использования
1. Приложение реализует все основные функции;
2. Все функциональные элементы пользовательского интерфейса имеют названия, описывающие действие, которое произойдет при выборе элемента.
3. Интерфейс не содержит лишних элементов.

<a name="security_requirements"/>

#### 3.2.1.2 Требования к безопасности
1. Приложение предоставляет возможность просмотра личной информации только зарегистрированного пользователя.
2. Приложение предоставляет возможность редактирования личной информации зарегистрированного пользователя.

<a name="access_requirements"/>

#### 3.2.1.3 Требования к доступности
Время реакции на действия пользователя минимально.

<a name="external_interfaces"/>

### 3.2.2 Внешние интерфейсы
Окна приложения удобны для использования пользователями:
* размер шрифта не должен быть слишком маленьким;
* интерфейс оформлен в соответствии с [Android стандартами](https://developer.android.com/guide/practices/ui_guidelines/index.html).

<a name="restrictions"/>

### 3.2.3 Ограничения
1. Приложение реализовано для ОС Android;
2. Язык, на котором реализована программа - Kotlin.
