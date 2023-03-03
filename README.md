# Cash Receipt

## The application runs java Main <set_parameters>, where the set of parameters in itemId-quantity format (itemId - item identifier, quantity - its quantity).
#
### For example: java Main 3-1 2-5 5-1 card-1234 will generate and will display a receipt in the console containing the name of the product with id = 3 in the amount of 1 piece, the same with id = 2 in the amount of 5 pieces, id = 5 - one piece, etc. Card-1234 means that a discount card with the number 1234 was presented.

### A file containing the receipt will also be generated.

![File_of_receipt](documents/pictures/ReceiptInFile.png)

#
### It is possible to run the application java Main <file_name>, the file type .txt contains a set of parameters in the format specified earlier.
![File_contains](documents/pictures/FileContains.png)
#
### An example how you can do it in console:

* set_parameters
  
  ![set_parameters](documents/pictures/Set_parameters.png)

* file_name

![file_name](documents/pictures/file_name.png)

#

***Among the goods there are promotional items. If there are more than five of them in the receipt, a 10% discount is made on that item. This information is reflected in the receipt.***

____
*Java 17.0.2.*
____
Patterns design:
+ Factory
+ Builder
+ Decorator
 