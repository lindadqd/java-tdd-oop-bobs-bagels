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
| publicMember      | -Basket basket                 | boolean addBagelToBasket(Bagel bagel)            | if basket is not full                            | add Bagel to Basket and return true            |
|                   | -Inventory inventory           |                                                  | if basket is full                                | return false                                   |
|                   |                                | boolean changeOrder(Item item)                   | if item in basket                                | remove item from Basket and return true        |
|                   |                                |                                                  | if item not in basket                            | return false                                   |
|                   |                                | boolean isBasketFull()                           | if basket is full                                | return true                                    |
|                   |                                |                                                  | if basket is not full                            | return false                                   |
| ----------------- | -----------------------------  | ----------------------------------------------   | ---------------------------------------------    | --------------------------------------------   |
| Manager           | Inherits basket and inventory  | boolean canOrder(Item item)                      | if item in Inventory                             | return true                                    |
|                   | from public member             |                                                  | if item not in Inventory                         | return false                                   | 
|                   |                                | boolean changeCapacity(int capacity)             | if capacity not negative                         | change basket capacity and return true         |
|                   |                                |                                                  | if capacity negative                             | return false                                   |
| ----------------- | -----------------------------  | -----------------------------------------------  | ----------------------------------------------   | ---------------------------------------------  |
| Customer          | Inherits basket and inventory  | float getTotalCost()                             | if Basket contains at least 1 item               | return total cost                              |
|                   | from public member             |                                                  | if Basket is empty                               | return 0                                       |
|                   |                                | float getBagelPrice(Bagel bagel)                 | always                                           | return Bagel price                             | 
|                   |                                | boolean addFilling(Bagel bagel, Filling filling) | if Filling is not null                           | add Filling to Bagel and return true           |
|                   |                                |                                                  | if Filling is null                               | return false                                   |
|                   |                                | float getFillingPrice(Filling filling)           | always                                           | return Filling price                           |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Basket            | -int capacity                  | List<Item> getItems()                            | if Basket contains at least one item             | return List of items                           |
|                   | -List<Item> items              |                                                  | if Basket is empty                               | return empty List                              |
|                   |                                | boolean changeOrder(Item item)                   | if item in basket                                | remove item from Basket and return true        |
|                   |                                |                                                  | if item not in basket                            | return false                                   |
|                   |                                | boolean addItemToBasket(Item item)               | if Basket is not full                            | add item to Basket and return true             |
|                   |                                |                                                  | if Basket is full                                | return false                                   |
|                   |                                | int getCurrentCapacity()                         | always                                           | return capacity                                |
|                   |                                |                                                  |                                                  |                                                |
|                   |                                | float getTotalCost()                             | if Basket contains at least one item             | return sum of all item prices                  |
|                   |                                |                                                  | if Basket is empty                               | return 0                                       |
|                   |                                | boolean changeCapacity(int capacity)             | if capacity not negative                         | change basket capacity and return true         |
|                   |                                |                                                  | if capacity negative                             | return false                                   |
|                   |                                | boolean isEmpty()                                | if Basket is empty                               | return true                                    |
|                   |                                |                                                  | if Basket is not empty                           | return false                                   |
|                   |                                | boolean isFull()                                 | if items.size() >= capacity                      | return true                                    |
|                   |                                |                                                  | if Basket is not full                            | return false                                   |
|                   |                                | int getNumberOfItems()                           | always                                           | return number of items                         |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Inventory         | -Map<String,Item> items        | boolean inInventory(String item)                 | if item in inventory map                         | return true                                    |
|                   |                                |                                                  | if item not in inventory map                     | return false                                   |
|                   |                                | Map<String,Item> getItemsInInventory()           | always                                           | return map of items                            |
|                   |                                |                                                  |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Item              | -float price                   | float getPrice()                                 | always                                           | return price                                   |
|                   | -String variant                | String getVariant()                              | always                                           | return variant                                 |
|                   | -String SKU                    | String getSKU()                                  | always                                           | return SKU                                     |
|                   | -String name                   | String getNAme()                                 | always                                           | return name                                    |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Bagel             | -List<Filling> fillings        | boolean addFilling(Filling filling)              | if Filling is not null                           | add Filling to Bagel ajd return true           |
|                   |                                |                                                  | if Filling is null                               | return false                                   |
|                   |                                | List<Filling> getFillings()                      | always                                           | return list of fillings                        |
|                   |                                | float getTotalPrice()                            | always                                           | return bagel price + sum of filling price      |
|                   |                                | Inherits all Item methods                        |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Coffee            |                                | Inherits all Item methods                        |                                                  |                                                |
| ----------------- | ------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ---------------------------------------------- |
| Filling           |                                | Inherits all Item methods                        |                                                  |                                                |