# Script para testar a API MovieFlix

Write-Host "=== Testando API MovieFlix ===" -ForegroundColor Green

# 1. Registrar usuario
Write-Host "`n1. Registrando usuario..." -ForegroundColor Yellow
$registerBody = @{
    name = "Teste User"
    email = "teste@movieflix.com"
    password = "senha123"
} | ConvertTo-Json

try {
    $registerResponse = Invoke-RestMethod -Uri "http://localhost:8080/movieflix/auth/register" `
        -Method Post `
        -ContentType "application/json" `
        -Body $registerBody
    Write-Host "Usuario registrado com sucesso!" -ForegroundColor Green
} catch {
    Write-Host "Usuario ja existe ou erro no registro" -ForegroundColor Yellow
}

# 2. Fazer login
Write-Host "`n2. Fazendo login..." -ForegroundColor Yellow
$loginBody = @{
    email = "teste@movieflix.com"
    password = "senha123"
} | ConvertTo-Json

$loginResponse = Invoke-RestMethod -Uri "http://localhost:8080/movieflix/auth/login" `
    -Method Post `
    -ContentType "application/json" `
    -Body $loginBody

$token = $loginResponse.token
Write-Host "Login realizado com sucesso!" -ForegroundColor Green
Write-Host "Token: $token" -ForegroundColor Cyan

# 3. Validar token
Write-Host "`n3. Validando token..." -ForegroundColor Yellow
try {
    $validateResponse = Invoke-WebRequest -Uri "http://localhost:8080/movieflix/auth/validate" `
        -Method Get `
        -Headers @{ Authorization = "Bearer $token" }
    
    if ($validateResponse.StatusCode -eq 200) {
        Write-Host "Token valido! (Status: 200)" -ForegroundColor Green
    }
} catch {
    Write-Host "Token invalido!" -ForegroundColor Red
}

Write-Host "`n=== Teste concluido ===" -ForegroundColor Green
