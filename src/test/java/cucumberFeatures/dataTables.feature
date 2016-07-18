Feature: test data tables cucumber
 @Thread2
 Scenario Outline: data tables should be parsed as required
   Given simple data table
  |pairId |NumberA|NumberB|
  |pair001|  11   |  55   |
  |pair002|  66   |   0   |
  |pair003|  33   |  33   |
   When we summ NumberA and NumberB
   Then summ should be equal <result>
  Examples:
   |result|
   |  66  |

