<div class="banner">
    <div class="logo">
        <i></i>
        <span class="webname">门户系统后台管理</span>
    </div>
    <div class="nav">
        <ul>
            <#if lists??>
                <#list lists as list>
                    <li>
                        <a href="javascript:">
                            <i class="${list.icon!}"></i>
                            <span>${list.name!}</span>
                        </a>
                    </li>
                </#list>
            </#if>
        </ul>
    </div>
</div>