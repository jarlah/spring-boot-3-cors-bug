# Reproduction of cors bug in spring boot with versioned controllers

1. `mvn test` errors out on preflight and get request 
    - The header `Access-Control-Allow-Origin` is expected to be returned as `*`. 
    - The header `Access-Control-Max-Age` is expected to be returned but is not.