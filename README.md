## Test-cases for https://www.olx.ua/uk/ webpage

### Test-case №1

#### Description

Attempt to log in with unregistered email must be failed and user must have been noticed that his email is not registered

#### Steps and expected results

1. **Open the webpage** - Homepage is opened
2. **Click the 'Ваш профіль' button at the header** - Login page must appear
3. **Enter some unregistered email and password** - 'Увійти' button is now available for clicking
4. **Click 'Увійти' button** - The message with the following text appears: 'Ми не знайшли профіль із цією адресою електронної пошти. Повторіть спробу, використовуючи іншу адресу, або створіть профіль.'

#### Coverage of test

1. Check whether the 'Увійти' button is unavailable with incorrect email or short password
2. Check whether the specific error message appears

---

### Test-case №2

#### Description

User should be able to create a list of favourite advertisements and this list should be persisted properly

#### Steps and expected results

1. **Open the webpage** - Homepage is opened
2. **Scroll down to the advertisements** - Some random ads are present and the heart icon is present for every ad
3. **Add some advertisements from the homepage to the favourites list by clicking heart icon** - The 'heart icon' color changes
4. **Go to the favourites webpage by clicking the following icon at the header** - The favourites webpage is opened and all the added ads are present

#### Coverage of test

1. Check whether there is an ability for adding ads to favourites
2. Check whether an icon for adding favourites changes
3. Check whether all the advertisements added to the favourites are present

---

### Test-case №3

#### Description

Every advertisement should contain basic information visible for user

#### Steps and expected results

1. **Open the webpage** - Homepage is opened
2. **Scroll down to the advertisements** - Some random ads are present
3. **Click the first advertisement** - The advertisement page is opened. The user is able to see its images, title, price, seller's contact buttons.

#### Coverage of test

1. Check whether the obligated elements(title, price, contact buttons, etc.) are present at the advertisement

---

### Test-case №4

#### Description

The user that knows what he wants to get should see an expected result using search

#### Steps and expected results

1. **Open the webpage** - Homepage is opened
2. **Enter some product name(f.e. 'airpods') in the search input** - Input element is fulfilled with some text
3. **Execute search by hitting 'Enter' button** - Webpage appears with the advertisements all matching the search input

#### Coverage of test

1. Check whether all the advertisements have searched product name in its titles

---

### Test-case №5

#### Description

Every advertisement selected by 'Обмін' filter should not contain price and instead should have 'Обмін' mark 

#### Steps and expected results

1. **Open the webpage** - Homepage is opened
2. **Click the 'Обмін' banner** - Webpage with the advertisements marked as 'Обмін' appears. It should be visible at the place of price
3. **Click any advertisement** - The advertisement page is opened. There should be text matches 'Обмін' at the place of price

#### Coverage of test

1. Check whether all the advertisements have 'Обмін' value instead of price
2. Check whether the exact advertisement has 'Обмін' value instead of price
