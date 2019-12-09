<template>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
        <FormItem prop="userName">
            <Input type="text" v-model="formInline.userName" placeholder="Username">
            <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem prop="password">
            <Input type="password" v-model="formInline.password" placeholder="Password">
            <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
        </FormItem>
    </Form>
</template>
<script>
    export default {
        data() {
            return {
                formInline: {
                    userName: '',
                    password: ''
                },
                ruleInline: {
                    userName: [
                        {required: true, message: 'Please fill in the user name', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: 'Please fill in the password.', trigger: 'blur'},
                        {
                            type: 'string',
                            min: 6,
                            message: 'The password length cannot be less than 6 bits',
                            trigger: 'blur'
                        }
                    ]
                }
            }
        },
        methods: {
        handleSubmit(name) {
                        this.$refs[name].validate((valid) => {
                            if (valid) {
                             this.$Message.error('表单submit!');
                                this.$axios({
                                    url: '/rest/Login',//请求的地址
                                    method: 'post',//请求的方式
                                    data: this.formInline//请求的表单数据
                                }).then(res => {
                                    console.info('后台返回的数据', res.data);
                                }).catch(err => {
                                    console.info('报错的信息', err.response.message);
                                });
                            } else {
                                this.$Message.error('表单校验失败!');
                            }
                        })
                    }
        }
    }
</script>
