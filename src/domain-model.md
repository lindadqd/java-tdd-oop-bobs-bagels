# User stories

As a member of the public:
- I'd like to add a specific type of bagel to my basket.
- I'd like to remove a bagel from my basket.
- I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
- I'd like to know if I try to remove an item that doesn't exist in my basket.

As a Bob's Bagel manager:
- I'd like to change the capacity of baskets.
- I want customers to only be able to order things that we stock in our inventory.

As a customer:
- I'd like to know the total cost of items in my basket.
- I'd like to know the cost of a bagel before I add it to my basket.
- I'd like to be able to choose fillings for my bagel.
- I'd like to know the cost of each filling.

| Classes           | Instance variable              | Methods                                          | Scenario                                         | Output                                         |
|-------------------|--------------------------------|--------------------------------------------------|--------------------------------------------------|------------------------------------------------|
| publicMember      | -Basket basket                 | boolean addBagelToBasket(String variant)         | if basket is not full and variant in Inventory   | add Bagel to Basket and return true            |
|                   | -Inventory inventory           |                                                  | if basket is full                                | return false                                   |
|                   |                                | boolean removeItem(String item)                  | if item in basket                                | remove item from Basket and return true        |
|                   |                                |                                                  | if item not in basket                            | return false                                   |
|                   |                                | boolean isBasketFull()                           | if basket is full                                | return true                                    |
|                   |                                |                                                  | if basket is not full                            | return false                                   |
| ----------------- | -----------------------------  | ----------------------------------------------   | ---------------------------------------------    | --------------------------------------------   |
| Manager           | Inherits basket and inventory  | boolean changeBasketCapacity(int capacity)       | if capacity not negative                         | change basket capacity and return true         |
|                   | from public member             |                                                  | if capacity negative                             | return false                                   |
| ----------------- | -----------------------------  | -----------------------------------------------  | ----------------------------------------------   | ---------------------------------------------  |
| Customer          | Inherits basket and inventory  | float getTotalCost()                             | always                                           | return total cost of items                     |
|                   |                                | float getBagelPrice(String variant)              | always                                           | return Bagel price                             | 
|                   |                                | boolean addFilling(String bagel,String filling)  | if Filling is not null                           | add Filling to Bagel and return true           |
|                   |                                |                                                  | if Filling is null                               | return false                                   |
|                   |                                | float getFillingPrice(String filling)            | always                                           | return Filling price                           |
|                   |                                | float getTotalBagelPrice(Bagel)                  | always                                           | return Bagel price with Filling                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Basket            | -int capacity                  | List<Item> getItems()                            | if Basket contains at least one item             | return List of items                           |
|                   | -List<Item> items              |                                                  | if Basket is empty                               | return empty List                              |
|                   |                                | boolean removeItem(String item)                  | if item in basket                                | remove item from Basket and return true        |
|                   |                                |                                                  | if item not in basket                            | return false                                   |
|                   |                                | boolean addItemToBasket(Item item)               | if Basket is not full and Item not Filling       | add item to Basket and return true             |
|                   |                                |                                                  | if Basket is full                                | return false                                   |
|                   |                                | int getCurrentCapacity()                         | always                                           | return capacity                                |
|                   |                                | float getTotalCost()                             | if Basket contains at least one item             | return sum of all item prices                  |
|                   |                                |                                                  | if Basket is empty                               | return 0                                       |
|                   |                                | boolean setCapacity(int capacity)                | if called by Manager                             | change basket capacity and return true         |
|                   |                                |                                                  | if not called by Manager                         | return false                                   |
|                   |                                | boolean isFull()                                 | if items.size() >= capacity                      | return true                                    |
|                   |                                |                                                  | if Basket is not full                            | return false                                   |
|                   |                                | int getNumberOfItems()                           | always                                           | return number of items                         |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Inventory         | -Map<String,Item> items        | boolean inInventory(String item)                 | if item in inventory map                         | return true                                    |
|                   |                                |                                                  | if item not in inventory map                     | return false                                   |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Item - interface  |                                | float getPrice()                                 | always                                           | return price                                   |
|                   |                                | String getVariant()                              | always                                           | return variant                                 |
|                   |                                | String getSKU()                                  | always                                           | return SKU                                     |
|                   |                                | String getNAme()                                 | always                                           | return name                                    |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Bagel             | -List<Filling> fillings        | boolean addFilling(Filling filling)              | if Filling is not null                           | add Filling to Bagel ajd return true           |
|                   | - float price                  |                                                  | if Filling is null                               | return false                                   |
|                   | - String variant               | List<Filling> getFillings()                      | always                                           | return list of fillings                        |
|                   | - String sku                   | float getTotalPrice()                            | always                                           | return bagel price + sum of filling price      |
|                   | - String name                  | boolean removeFilling(Filling filling)           | if Filling in fillings list                      | remove Filling from list and return true       |
|                   |                                |                                                  | if Filling not in fillings list                  | return false                                   |
|                   |                                | implements all Item methods                      |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Coffee            | - float price                  | implements all Item methods                      |                                                  |                                                |
|                   | - String variant               |                                                  |                                                  |                                                |
|                   | - String sku                   |                                                  |                                                  |                                                |
|                   | - String name                  |                                                  |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Filling           | - float price                  | implements all Item methods                      |                                                  |                                                |
|                   | - String variant               |                                                  |                                                  |                                                |
|                   | - String sku                   |                                                  |                                                  |                                                |
|                   | - String name                  |                                                  |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Order             | List<Item> orders              | Item createOrder(String variant)                 | if variant in Inventory                          | create Item and return Item                    |
|                   |                                |                                                  | if variant not in Inventory                      | return null                                    |
|                   |                                |                                                  |                                                  |                                                |
|                   |                                |                                                  |                                                  |                                                |
|                   |                                |                                                  |                                                  |                                                |
