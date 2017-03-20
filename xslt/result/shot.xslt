<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <xsl:for-each select="Object[@CCID='镜头子类']/MetaData">
                <Shot>
                    <Title>
                        <ShotTitle>
                            <xsl:value-of select="MetaData.Shot.Title.ShotTitle"/>
                        </ShotTitle>
                    </Title>
                    <Subject>
                        <xsl:for-each select="sAttribute[@strName='主题词']">
                            <SubjectTerm>
                                <xsl:value-of select="MetaData.Shot.Subject.SubjectTerm"/>
                            </SubjectTerm>
                        </xsl:for-each>
                        <xsl:for-each select="sAttribute[@strName='关键词']">
                            <Keyword>
                                <xsl:value-of select="MetaData.Shot.Subject.Keyword"/>
                            </Keyword>
                        </xsl:for-each>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="CMS/MetaData/Description/DescriptionofContent"/>
                        </DescriptionofContent>
                        <ShootingPlace>
                            <xsl:value-of select="MetaData.Shot.Description.ShootingPlace"/>
                        </ShootingPlace>
                        <xsl:for-each select="sAttribute[@strName='拍摄方式']">
                            <CameraMotion>
                                <xsl:value-of select="CMS/MetaData/Description/Caption/caption"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <xsl:for-each select="sAttribute[@strName='景别']">
                            <CameraMotion>
                                <xsl:value-of select="MetaData.Shot.Description.CameraMotion"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <xsl:for-each select="sAttribute[@strName='拍摄角度']">
                            <CameraMotion>
                                <xsl:value-of select="MetaData.Shot.Description.CameraMotion"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Shot.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>
                    <Date>
                        <xsl:value-of select="MetaData.Shot.Date"/>
                    </Date>
                    <Format>
                        <Duration>
                            <xsl:value-of select="CMS/MetaData/Clip/ClipFiles/ClipFile/ClipFileInfo/duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/Format/StartingPoint"/>
                        </StartingPoint>
                    </Format>
                </Shot>
            </xsl:for-each>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>