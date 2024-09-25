Feature: As an administrator (admin) I want to be able to access Hub List via API connection.

  Scenario Outline: admin Send a GET request to the api/hub/list endpoint with valid authorization, verify that the
  response status code is 200 and the message in the response body is 'Success'. Additionally, validate the
  details (name, phone, address, current_balance, status, created_at, updated_at) of the entry with id(x) in
  the response body.

    * The api user sets "api/hub/list" path parameters.
    # Api kullanicisi "api/hub/list" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Success".
    # Api kullanicisi response bodydeki message bilgisinin "Success" oldugunu dogrular
    * The api user verifies the information in the response body for the entry with the specified <dataindex> index, including "<name>", "<phone>", "<address>", "<current_balance>", <status>, "<created_at>" and "<updated_at>".
    # Api kullanıcısı response body icindeki <dataIndex> indexe sahip olanin "<name>", "<phone>", "<address>", "<current_balance>", <status>, "<created_at>" ve "<updated_at>" bilgilerini doğrular.

    Examples:
      | dataindex | name          | phone       | address                 | current_balance | status | created_at                  | updated_at                  |
      | 0         | New York City | 01000000001 | New York City, New York | 0.00            | 1      | 2023-08-01T14:12:21.000000Z | 2023-08-01T14:12:21.000000Z |


  Scenario: Invalid Token Send a GET request to the api/hub/list endpoint with invalid authorization, verify that the response
  status code is 401 and the message in the response body is 'Unauthenticated.'

    * The api user sets "api/hub/list" path parameters.
    # Api kullanicisi "api/hub/list" path parametrelerini olusturur
    * The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.
    # Api kullanicisi GET request gonderir, donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
