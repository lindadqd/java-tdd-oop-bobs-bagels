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


| Classes           | Methods                                             | Scenario                                         | Output                                         |
|-------------------|-----------------------------------------------------|--------------------------------------------------|------------------------------------------------|
| publicMember      | void addBagel(String variant)                       | if basket is not full and Bagel in inventory     | add Bagel to Basket                            |
|                   |                                                     | if basket is full                                | print "Basket is full"                         |
|                   | void changeOrder(String variant)                    | if Bagel in basket                               | remove Bagel from Basket                       |
|                   |                                                     | if Bagel not in basket                           | print "Bagel not in basket"                    |
|                   | void removeItem(String item)                        | if item in basket                                | remove item from Basket                        |
|                   |                                                     | if item not in basket                            | print "Item not in basket"                     |
| ----------------- | ----------------------------------------------      | ---------------------------------------------    | --------------------------------------------   |
| Manager           | boolean canOrder(String item)                       | if item in Inventory                             | customer can add to Basket                     |
|                   |                                                     | if item not in Inventory                         | return false                                   | 
|                   | boolean changeCapacity(Basket basket, int capacity) | if capacity not negative                         | change basket capacity                         |
|                   |                                                     | if capacity negative                             | return false                                   |
| ----------------- | -----------------------------------------------     | ----------------------------------------------   | ---------------------------------------------  |
| Customer          | float getTotalCost(Basket)                          | if Basket contains at least 1 item               | return total cost                              |
|                   |                                                     | if Basket is empty                               | return 0                                       |
|                   | float getBagelPrice(String variant)                 | if Bagel in inventory                            | return Bagel price                             | 
|                   |                                                     | if Bagel not in inventory                        | return 0                                       |
|                   | String addFilling(String variant)                   | if Filling in inventory                          | add Filling to Bagel                           |
|                   |                                                     | if Filling not in inventory                      | return "We don't have this kind of filling"    |
|                   | float getFillingPrice(String variant)               | if Filling in inventory                          | return Filling price                           |
|                   |                                                     | if Filling not in inventory                      | return 0                                       |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Basket            | List<Object> getItems()                             | if Basket contains at least one item             | return List of items                           |
|                   |                                                     | if Basket is empty                               | return empty List                              |
|                   | String changeOrder(String typeOfBagel)              | if Bagel in basket                               | remove Bagel from Basket                       |
|                   |                                                     | if Bagel not in basket                           | return "Bagel not in Basket"                   |
|                   | String removeItem(Basket)                           | if item in basket                                | remove item from Basket                        |
|                   |                                                     | if item not in basket                            | return "item not in Basket                     |
|                   | String checkBasket()                                | if Basket is full                                | return "Basket is full"                        |             
|                   |                                                     | if Basket is empty                               | return "Basket is empty"                       |
|                   |                                                     | if Basket contains at least one item             | return "Basket contains " + items              |
|                   | void changeCapacity(List<Basket> baskets)           | if Basket list not empty                         | change capacity of all baskets and new baskets |
|                   |                                                     | if Basket list empty                             | change capacity of all new baskets             |
|                   | float getTotalCost()                                | if Basket contains at least one item             | return total cost of basket                    |
|                   |                                                     | if Basket is empty                               | return 0                                       |
|                   | boolean changeCapacity(int capacity)                | if capacity not negative                         | change basket capacity                         |
|                   |                                                     | if capacity negative                             | return false                                   |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Inventory         | void inInventory(String SKU)                        | if item SKU in inventory                         | return true                                    |
|                   |                                                     | if item SKU not in inventory                     | return false                                   |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Item              | float getPrice()                                    | if item in inventory                             | return price                                   |
|                   |                                                     | if item not in inventory                         | return 0                                       |
|                   | String getVariant()                                 | if item in inventory                             | return variant                                 |
|                   |                                                     | if item not in inventory                         | return "We don't have this filling!"           |
|                   | String getSKU()                                     | -                                                | return SKU                                     |                                                |                                                  |                                                |
|                   |                                                     |                                                  |                                                |
|                   |                                                     |                                                  |                                                |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Bagel             | float getPrice()                                    | if Bagel in inventory                            | return price                                   |
|                   |                                                     | if Bagel not in inventory                        | return 0                                       |
|                   | String getVariant()                                 | if Bagel in inventory                            | return variant                                 |
|                   |                                                     | if Bagel not in inventory                        | return "We don't have this filling!"           |
|                   | void addFilling(Filling variant)                    | if Filling in inventory                          | add Filling to Bagel                           |
|                   |                                                     | if Filling not in inventory                      | print "We don't have this filling!"            |
|                   | String getSKU()                                     | -                                                | return SKU                                     |
|                   |                                                     |                                                  |                                                |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Coffee            | float getPrice()                                    | if Coffee in inventory                           | return price                                   |
|                   |                                                     | if Coffee not in inventory                       | return 0                                       |
|                   | String getVariant()                                 | if Coffee in inventory                           | return variant                                 |
|                   |                                                     | if Coffee not in inventory                       | return "We don't have this coffee!"            |
|                   | String getSKU()                                     | -                                                | return SKU                                     |
|                   |                                                     |                                                  |                                                |
| ----------------- | ------------------------------------------------    | ------------------------------------------------ | ---------------------------------------------- |
| Filling           | float getPrice()                                    | if Filling in inventory                          | return price                                   |
|                   |                                                     | if Filling not in inventory                      | return 0                                       |
|                   | String getVariant()                                 | if Filling in inventory                          | return variant                                 |
|                   |                                                     | if Filling not in inventory                      | return "We don't have this filling!"           |
|                   | String getSKU()                                     | -                                                | return SKU                                     |
|                   |                                                     |                                                  |                                                |
|                   |                                                     |                                                  |                                                |