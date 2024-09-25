Feature: As an administrator (admin), I want to be able to delete hub information with the specified id number via API connection.

  Scenario: admin Send a DELETE request to the api/hub/delete/{id} endpoint with valid authorization and correct id, verify
  that the response status code is 200, the message is 'Deleted', and the 'Deleted ID' in the response body matches
  the id in the path. Then, confirm the deletion by sending a GET request to api/hub/{id} to verify the hub has been removed.

    * The api user sets "api/hub/delete" path parameters.
    # Api kullanicisi "api/hub/delete/{id}" path parametrelerini olusturur
    * The api user sends a "DELETE" request and saves the returned response.
    # Api kullanicisi DELETE request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Deleted".
    # Api kullanicisi response bodydeki message bilgisinin "Deleted" oldugunu dogrular
    * The api user verifies that the "data" "Deleted ID" information in the returned response body is the same as the id path parameter written in the endpoint.
    # Api kullanicisi donen response body icindeki "data" "Deleted ID" bilgisinin endpointde yazan id path parametresi ile ayni oldugunu dogrular
