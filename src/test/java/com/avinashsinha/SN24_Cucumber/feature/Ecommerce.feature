Feature: Purchase an order from Ecommerce Website

  @Smoke
  Scenario Outline: Positive Test of Submitting the Order
    Given User logged in with "<username>" and "<password>"
    When User adds product "<productName>" to cart
    And User proceeds to checkout
    And User submits the order for "<productName>"
    Then User sees "THANKYOU FOR THE ORDER." message on confirmation page

    Examples:
      | username          | password    | productName |
      | anshika@gmail.com | Iamking@000 | ZARA COAT 3 |