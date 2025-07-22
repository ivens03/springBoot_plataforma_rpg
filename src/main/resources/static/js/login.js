/* src/main/resources/static/js/login.js */

document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');
    const showRegisterLink = document.getElementById('show-register');
    const showLoginLink = document.getElementById('show-login');

    // Mostrar mensagem de sucesso se o registro foi bem-sucedido
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('registered') === 'true') {
        alert('Cadastro realizado com sucesso! Faça login para continuar.');
    }

    // Função para alternar para o formulário de registro
    showRegisterLink.addEventListener('click', (e) => {
        e.preventDefault();
        loginForm.classList.add('hidden');
        registerForm.classList.remove('hidden');
        // Rolar para o topo do formulário de registro
        registerForm.scrollIntoView({ behavior: 'smooth' });
    });

    // Função para alternar para o formulário de login
    showLoginLink.addEventListener('click', (e) => {
        e.preventDefault();
        registerForm.classList.add('hidden');
        loginForm.classList.remove('hidden');
        // Rolar para o topo do formulário de login
        loginForm.scrollIntoView({ behavior: 'smooth' });
    });
});