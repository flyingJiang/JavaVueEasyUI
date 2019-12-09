<template>
    <div id="app">
        <Login></Login>
        <a href="one.html">one</a><br>
        <a href="datagrid.html">datagrid</a><br>
    </div>
</template>
<script>
    import Login from '@/components/Login'
    import easyuiDemo from '@/components/easyuiDemo'
    export default {
        name: 'App',
        components: {
            'Login': Login,
            'easyuiDemo': easyuiDemo
        },
        data() {
            return {}
        }
    }
</script>
<style>
    #app {
        text-align: center;
        margin-top:400px ;
    }
</style>
