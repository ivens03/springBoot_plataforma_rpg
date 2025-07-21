/* src/main/resources/static/js/login-rpg.js */

document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');
    const showRegisterLink = document.getElementById('show-register');
    const showLoginLink = document.getElementById('show-login');

    // Função para alternar para o formulário de registro
    showRegisterLink.addEventListener('click', (e) => {
        e.preventDefault();
        loginForm.classList.add('hidden');
        registerForm.classList.remove('hidden');
    });

    // Função para alternar para o formulário de login
    showLoginLink.addEventListener('click', (e) => {
        e.preventDefault();
        registerForm.classList.add('hidden');
        loginForm.classList.remove('hidden');
    });

    // Simulação de envio de formulário de login
    loginForm.querySelector('form').addEventListener('submit', (e) => {
        e.preventDefault();
        const email = document.getElementById('login-email').value;
        console.log(`Tentativa de login com o email: ${email}`);
        alert('Login simulado com sucesso! Verifique o console.');
    });

    // Simulação de envio de formulário de registro
    registerForm.querySelector('form').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('register-name').value;
        const email = document.getElementById('register-email').value;
        console.log(`Tentativa de registro para o Herói: ${name} com o email: ${email}`);
        alert('Registro simulado com sucesso! Verifique o console.');
    });
});